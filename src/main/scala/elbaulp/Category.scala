package elbaulp

object Category {
  // Identity object of a category
  // Bartosz Milewski Essence of Composition Challenge 1.
  /**
    * The Identity function.
    * @params x The input
    * @return the given input
    *
    * Identity properties:
    *  - f ∘ id = f = id ∘ f
    */
  def Id[T](x: T) = x

  // Bartosz Milewski Essence of Composition Challenge 2.
  // Implement the composition function in your favorite language.
  // It takes two functions as arguments and returns a function that is their composition.
  /**
    * Composition function.
    * @params f a function from A -> B
    * @params g a function from B -> C
    * @return The composition of the two, g ∘ f
    *
    * Composition properties:
    * - Associativity: h∘(g∘f) = (h∘g)∘f = h∘g∘f
    */
  def compose[A, B, C](f: A => B, g: B => C): A => C = f andThen g
}
