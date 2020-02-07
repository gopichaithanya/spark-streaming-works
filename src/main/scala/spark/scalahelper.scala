package spark

object scalahelper extends App {
     implicit  class IntWithTimes(x:Int){
       def times[A](f: => A):Unit={
         def loop(current : Int): Unit =
           if(current > 0){
             f
             loop(current - 1)
           }
         loop(x)

       }
     }
import scalahelper._
10 times println("Hiii scala implicit classes")

}
