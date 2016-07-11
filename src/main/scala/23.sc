import scalaz._, Scalaz._

/**
  * Tree
  *
  */


def freeTree: Tree[Char] =
  'P'.node(
    'O'.node(
      'L'.node('N'.leaf, 'T'.leaf),
      'Y'.node('S'.leaf, 'A'.leaf)),
    'L'.node(
      'W'.node('C'.leaf, 'R'.leaf),
      'A'.node('A'.leaf, 'C'.leaf)))


def changeToP(tree: Tree[Char]): Tree[Char] = tree match {
  case Tree.Node(x, Stream(
  l, Tree.Node(y, Stream(
  Tree.Node(_, Stream(m, n)), r)))) =>
    x.node(l, y.node('P'.node(m, n), r))
}

changeToP(freeTree)

freeTree.loc.getChild(2) >>= {
  _.getChild(1)
}

freeTree.loc.getChild(2) >>= {
  _.getChild(1)
} >>= {
  _.getLabel.some
}

val newFocus = freeTree.loc.getChild(2) >>= {
  _.getChild(1)
} >>= {
  _.modifyLabel({ _ => 'P' }).some
}

newFocus.get.toTree
newFocus.get.toTree.draw foreach {
  _.print
}
