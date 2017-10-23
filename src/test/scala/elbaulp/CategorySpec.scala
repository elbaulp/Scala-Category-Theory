import elbaulp.Category
import org.scalacheck.Prop._

object fixtures {
  val f = (x: Int) => x.toDouble
  val g = (y: Double) => y * y
  val h = (z: Double) => z.toString

  def square(a: Int) = a * a
}

// BDD tests
class CategoryBDDSpec extends BddSpec {
  import fixtures._
  "A Category" - {
    "When calling its Identity" - {
      "Should be computed correctly" in {
        assert(Category.Id(10) == 10)
      }
    }
    "When composing it" - {
      "Should be associative" in {
        assert(Category.compose(Category.compose(f, g), h)(1) ==
          Category.compose(f, Category.compose(g, h))(1))
      }
    }
  }
}

// Thanks to http://blog.ssanj.net/posts/2016-07-06-how-to-run-scalacheck-from-scalatest-and-generate-html-reports.html
// for help me use scalacheck from scalatest
class CategoryPropSpec extends CheckSpec {
  import fixtures._

  property("a == Id(a)") {
    check(forAll { i:String =>
      Category.Id(i) === i
    })
  }

  property("Id∘f = f") {
    check(forAll { i: Int =>
      Category.Id(square(i)) === square(i)
    })
  }

  property("f∘Id = f") {
    check(forAll { i: Int =>
      f(Category.Id(i)) === f(i)
    })
  }

  property("Associativity: h∘(g∘f) = (h∘g)∘f = h∘g∘f"){
    check(forAll { i: Int =>
      Category.compose(Category.compose(f, g), h)(i) === Category.compose(f, Category.compose(g, h))(i)
    })
  }
}
