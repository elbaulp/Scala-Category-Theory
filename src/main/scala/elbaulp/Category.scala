package elbaulp

/* Typeclass to represent "any" category */
trait Category[~>[_, _]] {

  /* Abstract typeclass methods */

  def id[A]: A ~> A

  def compose[A, B, C](f: B ~> C, g: A ~> B): A ~> C

  /* Category laws */

  trait Laws {

    def leftIdentity[A, B](f: A ~> B)(implicit Eq: Equal[A ~> B]): Boolean =
      Eq.equal(compose(f, id), f)

    def rightIdentity[A, B](f: A ~> B)(implicit Eq: Equal[A ~> B]): Boolean =
      Eq.equal(compose(id, f), f)

    def associativity[A, B, C, D](
        f: A ~> B,
        g: B ~> C,
        h: C ~> D)(implicit
        Eq: Equal[A ~> D]): Boolean =
      Eq.equal(compose(compose(h, g), f), compose(h, compose(g, f)))
  }
}

/* Category companion object, where typeclass instances rely */
object Category {

  def apply[~>[_, _]](implicit C: Category[? ~> ?]): Category[? ~> ?] = C

  // Hask instance of category, where objects are types and arrows are functions
  implicit val haskCategory: Category[? => ?] = new Category[? => ?] {

    // Identity object of a category
    // Bartosz Milewski Essence of Composition Challenge 1.
    /**
      * The Identity function.
      * @return the identity function
      *
      * Identity properties:
      *  - f ∘ id = f = id ∘ f
      */
    def id[A] = identity

    // Bartosz Milewski Essence of Composition Challenge 2.
    // Implement the composition function in your favorite language.
    // It takes two functions as arguments and returns a function that is their composition.
    /**
      * Composition function.
      * @params f a function from B -> C
      * @params g a function from A -> B
      * @return The composition of the two, f ∘ g
      *
      * Composition properties:
      * - Associativity: h∘(g∘f) = (h∘g)∘f = h∘g∘f
      */
    def compose[A, B, C](f: B => C, g: A => B): A => C = f compose g
  }
}

// Typeclass to define laws in a generic way
trait Equal[A] {
  def equal(a1: A, a2: A): Boolean
}

object Equal {
  // ... (instances to enable scalacheck testing)
}
