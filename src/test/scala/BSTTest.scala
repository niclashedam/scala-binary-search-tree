import org.scalatest._
import am.hed.BST

class BSTTest extends FlatSpec {
  "The BST" should "return its size recursively" in {
    val bst = new BST[String, Int]

    assert(bst.size() === 0)

    bst.insert("foo", 8)
    bst.insert("bar", 2)
    bst.insert("baz", 6)

    assert(bst.size() === 3)
  }

  it should "be able to find inserted keys (order them correctly)" in {
    val bst = new BST[String, Int]

    bst.insert("foo", 8)
    bst.insert("bar", 2)
    bst.insert("baz", 6)
    bst.insert("qux", -3)
    bst.insert("quux", 12)
    bst.insert("corge", 5)

    assert(bst.find("foo") === Some(8))
    assert(bst.find("bar") === Some(2))
    assert(bst.find("baz") === Some(6))
    assert(bst.find("qux") === Some(-3))
    assert(bst.find("quux") === Some(12))
    assert(bst.find("corge") === Some(5))
  }

  it should "be return None if key is not found" in {
    val bst = new BST[String, Int]

    assert(bst.find("foo") === None)
  }

  it should "be able to find the minimum and maximum value" in {
    val bst = new BST[String, Int]

    bst.insert("foo", 8)
    bst.insert("bar", 2)
    bst.insert("baz", 6)
    bst.insert("qux", -3)
    bst.insert("quux", 12)
    bst.insert("corge", 5)

    assert(bst.max() === Some(-3)) // qux
    assert(bst.min() === Some(2)) // bar
  }
}
