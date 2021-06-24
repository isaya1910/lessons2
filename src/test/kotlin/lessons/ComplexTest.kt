package lessons

import org.junit.Test
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith


internal class ComplexTest {
    @Test
    fun testComplexInitialization() {
        assertFailsWith<IllegalArgumentException> { Complex.complexFromNegativeValue(5) }
        assertFailsWith<IllegalArgumentException> { Complex.complexFromPositiveValue(-5) }
        assertEquals(Complex.complexFromPositiveValue(10).data, 10)
        assertEquals(Complex.complexFromZeroValue().data,0)
    }
}