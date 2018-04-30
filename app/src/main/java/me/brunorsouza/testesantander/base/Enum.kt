package me.brunorsouza.testesantander.base

enum class Type(val position: Int) {
    field(1),
    text(2),
    image(3),
    checkbox(4),
    send(5)
}

enum class TypeField(val position: Int) {
    text(1),
    telNumber(2),
    email(3)
}