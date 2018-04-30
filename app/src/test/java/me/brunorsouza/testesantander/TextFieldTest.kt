package me.brunorsouza.testesantander

import me.brunorsouza.testesantander.contact.view.cell.TextFieldCell
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TextFieldTest {

    lateinit var cellType: TextFieldCell

    val VALID_TEXT = "text"

    val INVALID_TEXT = ""

    @Before
    fun setUp(){
        cellType = TextFieldCell()
    }

    @Test
    fun testValidText(){
        val isValid = cellType.validate(VALID_TEXT)

        Assert.assertTrue(isValid)
    }

    @Test
    fun testInvalidText(){
        val isValid = cellType.validate(INVALID_TEXT)

        Assert.assertFalse(isValid)
    }

}