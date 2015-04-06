import scala.actors.Actor
import scala.actors.Actor._

class Echoer(i: Int) extends Actor {
    def act() {
        val id = Thread.currentThread.getId()
        while(true) {
            receive {
                case x:Int => printf("Echo(%d, %d): %s\n", i, id, x)
                case x:Any => printf("Echo(%d, %d): unk %s\n", i, id, x)
            }
        }
    }
}

val echoers = (1 to 100).map(i => new Echoer(i))

echoers.foreach(_.start)

for(e <- echoers) {
    e ! 1
    e ! 2
    e ! "hello"
}

println("All done")
