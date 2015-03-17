

sealed trait PseudoCollection[+T]

import scala.collection.mutable._

class Box[+T] extends PseudoCollection[T]{

    //private var buffer = ListBuffer[T]()
    //Replacing Any with T causes a compile time error
    private var buffer = ListBuffer[Any]()

    override def toString() = buffer.toString

    def add[A1 >: T](t : A1) =  { buffer += t.asInstanceOf[T] }
}

sealed trait PreciousMetal
class Gold(val name:String = "Gold") extends PreciousMetal
class Silver(val name:String = "Silver") extends PreciousMetal
class BarGold(override val name:String = "Bar Gold") extends Gold

object Box {
  // Simple example for covariant type class and limits
  def main(args: Array[String]) {
		val preciousMtlBox = new Box[PreciousMetal]()
		preciousMtlBox.add(new Gold("Golden Ring"))
		preciousMtlBox.add(new Silver("Silver Ring"))
		
		
		val goldOnlyBox = new Box[Gold]()
		goldOnlyBox.add(new Gold("Some golden jewel"))
		goldOnlyBox.add(new BarGold("Some golden bar"))
		
		println(preciousMtlBox)
		println(goldOnlyBox)
	}
	
}