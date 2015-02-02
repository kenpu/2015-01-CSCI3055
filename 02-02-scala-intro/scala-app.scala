
object Hello {
    def main(args: Array[String]) : Unit = {
        if(args.length != 3) {
            println("Usage: <tax rate> <price> <age>")
            return
        }

        val tax   = args(0).toFloat
        val price = args(1).toFloat
        val age   = args(2).toFloat

        println("Price after tax is: " + 
            (if(age < 25) price else price*(1+tax)))
    }
}
