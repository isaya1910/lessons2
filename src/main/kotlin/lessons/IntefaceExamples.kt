package lessons


interface ComplexApi {
    fun getComplexWithPositiveValue(value: Int): Complex
}


class LocalComplexApi : ComplexApi {
    override fun getComplexWithPositiveValue(value: Int): Complex {
        return Complex.complexFromPositiveValue(value)
    }

}