# in-scalaz
Adopt scalaz in practice. Project for self education. In progress.


## Content
1. First example shows how to create own `Semigroup` and `Monoid`. 
Check the `1.sc`. 
2. Second example shows the generic fold function for list and tree.
3. Another example with monoid. 
4. Equal
5. Order
6. Show
7. Enum
8. Own type classes and equal
9. Functor
10. Applicative
11. Taged type
12. Monoid
13. Functor laws
14. ...



## Terms
`Semigroup` - requires to be associative.

`Monoid` - A monoid is a set that is closed under an associative binary 
operation and has an identity element. It can be also thought of as a 
semigroup with and identity element. A monoid must contain at least one 
element. Monoid - law requires on + and 0.

`Foldable` - means that contains something that already has a 
monoid instance.

`Functor` is a typeclass, which is supports map function
so it can be mapped over.

`Applicative  functor` - knows how to apply function to a
value which is boxed in the  some context and return the new
value boxed in the same context.

`Tagged type` - is made for cases when we want to just take one type and wrap
it in something to present it as another type.

A `monoid` is when you have an associative binary function and a value which 
acts as an identity with respect to that function.

The `first functor law` states that if we map the identity function over a functor, 
the functor that we get back should be the same as the original functor.

The `second law` says that composing two functions and then mapping the 
resulting function over a functor should be the same as first mapping one 
function over the functor and then mapping the other one.

