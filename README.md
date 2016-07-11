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
14. Monads
15. MonadPlus
16. Monad laws
17. Writer
18. State
19. \/
20. Validation
21. Kleisli
22. ...



## Terms
`Semigroup` - requires to be associative.

`Monoid` - A monoid is a set that is closed under an associative binary 
operation and has an identity element. It can be also thought of as a 
semigroup with and identity element. A monoid must contain at least one 
element. Monoid - law requires on + and 0.

`Foldable` - means that contains something that already has a 
monoid instance. Foldable is for things that can be folded up.

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

`Monad` is an extension of applicative functor and provides a solution to the problem:
how to apply a function that takes a normal value to a value
with context and return the value with the context.

The `MonadPlus` type class is for `monads` that can also act as monoids.


The `first monad law` states that if we take a value, put it in a default 
context with return and then feed it to a function by using >>=, it’s the same as 
just taking the value and applying the function to it.


The `second monad law` states that if we have a monadic value and we use >>= to feed 
it to return, the result is our original monadic value.

The `third monad law` says that when we have a chain of monadic function 
applications with >>=, it shouldn’t matter how they’re nested.

`Writer` is a newtype wrapper to attach a monoid to a value.

A `stateful` computation is a function that takes some state and returns a value along 
with some new state. That function would have the following type: s -> (a, s)
 
The `Either` is a type that allows us to incorporate a context of possible 
failure to our values while also being able to attach values to the failure, 
so that they can describe what went wrong or provide some other useful 
info regarding the failure.

The difference between `Validation` and `Either` is that it is not a monad, but it’s an applicative functor.

`Monadic functions` are either operate on monadic values or return monadic values as their results (or both!).

