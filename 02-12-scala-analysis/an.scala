import scala.io.Source

type Record = Map[String, String]

def parseLines(lines: List[String]): List[Record] = {
    for (line <- lines) yield lineToMap(line)
}

def lineToMap(line: String): Record = {
    val fields = line split "\t"
    val course = fields(1) match {
        case x if x contains "3055" => "PL"
        case x if x contains "4020" => "COM"
        case x if x contains "2020" => "SYS"
        case _ => "Unknown"
    }
    val social = fields(2) match {
        case x if x contains "blackboard" => "bb"
        case _ => "g+"
    }
    val content = fields(4) match {
        case x if x contains "power" => "pp"
        case _ => "html"
    }

    Map("course" -> course, 
        "social" -> social,
        "content" -> content)
}

def groupby(results: List[Record], key: String): Map[String, Int] = {
    val f: (Record) => String = {
        x => x(key)
    }

    val g = results.groupBy(f).toList.map({x => (x._1, x._2.length)})

    Map(g: _*)
}

val lines = Source.fromFile("survey.tsv").getLines().toList.tail
val results = parseLines(lines)

println(groupby(results, "social"))
println(groupby(results, "content"))

for(c <- List("PL", "COM", "SYS")) {
    println(s"Social of ${c}")
    println(groupby(results.filter(_("course") == c), "social"))

    println(s"Content of ${c}")
    println(groupby(results.filter(_("course") == c), "content"))
}
