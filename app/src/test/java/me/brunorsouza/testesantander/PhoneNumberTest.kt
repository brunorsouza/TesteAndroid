package me.brunorsouza.testesantander

import me.brunorsouza.testesantander.contact.view.PhoneNumberFieldCell
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PhoneNumberTest {

    lateinit var cellType: PhoneNumberFieldCell

    val VALID_CELL_PHONE_NUMBER = "(11)98765-4321"

    val INVALID_PHONE_NUMBER = "(11)890"

    @Before
    fun setUp(){
        cellType = PhoneNumberFieldCell()
    }

    @Test
    fun testValidateCorrectNumber(){
        val isValid = cellType.validate(VALID_CELL_PHONE_NUMBER)

        Assert.assertTrue(isValid)
    }

    @Test
    fun testValidateInvalidNumber(){
        val isValid = cellType.validate(INVALID_PHONE_NUMBER)

        Assert.assertFalse(isValid)
    }

}