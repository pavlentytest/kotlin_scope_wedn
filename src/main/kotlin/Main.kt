fun main(args: Array<String>) {
    val ivan = Person("Ivan", null)
    // let()
    ivan.email?.let { println(it) }
    // или если идет обращение только к it
    ivan.email?.let(::println)

    // без let
    if(ivan.email != null) println(ivan.email)

    // with()
    val oleg = Person("Oleg", null)
    val result = with(oleg){
        if(email == null)
            email = "oleg@oleg.ru"
        email
    }
    // run() - похожа на with(), но реализована как функция расширения

    val obj1 = MyClass(12,3)
    obj1.action()
    obj1.action2()

    val maria = Person("Maria", null)
    val res = maria.run {
        if(email == null)
            email = "maria@maria.ru"
        email
    }
    println(res)

    // проверка на null
    val alex = Person("Alex", null)
    val rr = alex.email?.run{ "valid" } ?: "Undefined"
    println(rr) // Undefined

    val text = run { "Hello" }
    println(text)
    // или
    run { println("ttt") } // ttt

    // apply()
    val vasya = Person("Vasya", null)
    vasya.apply {
        if(email == null)
            email = "vasya@vasya.ru"
        email
    }
    println(vasya.email)

    // apply можно использовать при построении объекта в виде паттерна Builder
    val aaa = Worker()
    aaa.name("AAA")

    // also() - аналогично apply()
    val max = Person("Max", null)
    max.also {
        if(it.email == null)
            it.email = "max@max.ru"
    }
    println(max.email)


}
data class Worker (var name: String = "") {
    fun name(_name: String): Worker = apply { name = _name }
}
data class Person(val name: String, var email: String?)
class MyClass(val a: Int = 0, val b: Int = 0){
    fun action() {
        println(a-b)
    }
}
fun MyClass.action2() {
    println(a+b)
}