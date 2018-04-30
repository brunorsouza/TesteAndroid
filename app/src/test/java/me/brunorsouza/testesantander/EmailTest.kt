package me.brunorsouza.testesantander

import me.brunorsouza.testesantander.contact.view.cell.EmailFieldCell
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class EmailTest {

    lateinit var cellType: EmailFieldCell

    val VALID_EMAIL = "bruno@mail.com"

    val INVALID_EMAIL = "bruno"

    @Before
    fun setUp(){
        cellType = EmailFieldCell()
    }

    @Test
    fun testCorrectEmail(){
        val isValid = cellType.validate(VALID_EMAIL)

        assertTrue(isValid)
    }

    @Test
    fun testInvalidEmail(){
        val isValid = cellType.validate(INVALID_EMAIL)

        assertFalse(isValid)
    }

}