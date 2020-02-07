package spark

object spark01 extends App  {

  val myArray=Array(14,2,5,1,2,6)
  for(i <- 0 to myArray.length-2)
    {
      var min=myArray(i)
      var pos =i
      for(j <- i to  myArray.length-1){
        if(min > myArray(i))
          {
            min=myArray(j)
            pos = j
          }
        if(myArray(i)!=min){
          val temp=myArray(pos)
          myArray(pos)=myArray(i)
          myArray(i)=temp
        }
      }
      println(myArray deep)
    }

}
