package convenience

import java.io.File
import java.nio.file.Paths

import scala.collection.Iterator
import scala.io.Source

import convenience.collections._

object io {
//
//  implicit class RichString(s: String) {
//    def toPath = Paths.get(s)
//    def toFile = new File(s)
//  }
//
//  def open(f: File) = f.open()
//
//  def open[T](f: File)(func: Source => T): T = f.open(func)
//
//  def open(fileName: String) = Source.fromFile(fileName)
//
//  def open[T](fileName: String)(func: Source => T) = new File(fileName).open(func)
//
//  implicit class RichSource(s: Source) {
//    def lines(): Iterator[String] = {
//      s.getLines()
//    }
//
//    def line(n: Int) = {
//      lines().nth(n)
//    }
//  }
//
//  implicit class RichFile(f: File) {
//    def open() = {
//      Source.fromFile(f)
//    }
//
//    /**
//     * Automatically close
//     */
//    def open[ReturnType](f: Source => ReturnType): ReturnType = {
//      val source = open()
//      val ret = f(source)
//      source.close()
//      ret
//    }
//
//    def /(child: String) = new File(f, "/" + child)
//
//    def parentName = f.getParentFile.getName
//  }
}