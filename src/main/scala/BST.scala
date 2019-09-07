package am.hed

class BST[K, V](implicit ord: Ordering[K]) {
  private sealed trait Tree[K, V]
  private case object Leaf extends Tree[K, V]
  private case class Branch[K, V](
      left: Tree[K, V],
      right: Tree[K, V],
      k: K,
      v: V
  ) extends Tree[K, V]

  private var root: Tree[K, V] = Leaf

  def size(): Int = {
    size(this.root)
  }

  def insert[A](k: K, v: V): Unit = {
    this.root = insert(root, k, v);
  }

  def find(k: K): Option[V] = {
    find(root, k)
  }

  private def find(t: Tree[K, V], key: K): Option[V] = t match {
    case Leaf => None
    case Branch(l, r, k, v) =>
      if (ord.equiv(k, key)) Some(v)
      else if (ord.lt(key, k)) find(l, key)
      else find(r, key)
  }

  private def insert(t: Tree[K, V], key: K, value: V): Tree[K, V] = t match {
    case Leaf                                      => Branch(Leaf, Leaf, key, value)
    case Branch(l, r, k, v) if (ord.equiv(k, key)) => Branch(l, r, k, value)
    case Branch(l, r, k, v) if (ord.lt(key, k)) =>
      Branch(insert(l, key, value), r, k, v)
    case Branch(l, r, k, v) => Branch(l, insert(r, key, value), k, v)
  }

  private def size(t: Tree[K, V]): Int = t match {
    case Leaf               => 0
    case Branch(l, r, _, _) => 1 + size(l) + size(r)
  }
}
