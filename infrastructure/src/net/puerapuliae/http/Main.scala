import akka.actor.{Cancellable, Actor, ActorSystem, Props}
import akka.stream.ActorMaterializer
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
 
object Main extends App {
//  implicit val system = ActorSystem("my-system")
//  implicit val materializer = ActorMaterializer()
 
//  val route =
//    path("hello" /) {
//      get {
//        complete {
//          "Hallo"
//        }
//      }
//    }
 
//  val bindingFuture = Http().bindAndHandle(route, "localhost", 3000)
 
  println(s"Server online at http://localhost:3000/\nPress RETURN to stop...")
//  Console.readLine()
 
//  import system.dispatcher // for the future transformations
//  bindingFuture
//    .flatMap(_.unbind()) // trigger unbinding from the port
//    .onComplete(_ ⇒ system.shutdown()) // and shutdown when done
}
