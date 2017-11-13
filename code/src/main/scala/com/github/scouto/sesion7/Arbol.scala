package com.github.scouto.sesion7
/**
  * Created by couto on 27/06/17.
  */
sealed trait Arbol[+A]
case class Hoja[A](value: A) extends Arbol[A]
case class Rama[A](left: Arbol[A], right: Arbol[A]) extends Arbol[A]

object Arbol {

  def size[A] (t: Arbol[A]): Int = {
    t match {
      case Hoja(_) => 1
      case Rama(l, r) => 1+ size(l) + size(r)
    }
  }

  def maximum (t: Arbol[Int]): Int = {
    t match {
      case Hoja(x) => x
      case Rama(l, r) => maximum(l) max maximum(r)
    }
  }

  def depth[A] (t:Arbol[A]) : Int = {
    t match {
      case Hoja(_) => 1
      case Rama(l, r) => 1 + (depth(l) max depth(r))
    }
  }

  def map[A, B] (t:Arbol[A])(implicit f:A => B): Arbol[B] = {
    t match {
      case Hoja(a) => Hoja(f(a))
      case Rama(l, r) => Rama(map(l), map(r))
    }
  }

  def fold[A, B] (t:Arbol[A])(f: A=> B)(g: (B, B) => B): B = ???

  def sizeFold[A] (t: Arbol[A]): Int = ???


  def maximumFold (t: Arbol[Int]): Int = ???

  def depthFold[A] (t:Arbol[A]) : Int = ???

  def mapFold[A, B] (t:Arbol[A])(f:A => B): Arbol[B] = ???
}

