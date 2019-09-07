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

  "The BST" should "be able to find inserted keys (order them correctly)" in {
    val bst = new BST[String, Int]

    bst.insert("foo", 8)
    bst.insert("bar", 2)
    bst.insert("baz", 6)

    assert(bst.find("foo") === Some(8))
    assert(bst.find("bar") === Some(2))
    assert(bst.find("baz") === Some(6))
    assert(bst.find("quux") === None)
  }
}
