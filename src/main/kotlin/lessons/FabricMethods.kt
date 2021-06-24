package lessons


class Complex private constructor(val data: Int) {
    companion object {
        fun complexFromPositiveValue(data: Int): Complex {
            require(data > 0)
            return Complex(data)
        }

        fun complexFromNegativeValue(data: Int): Complex {
            require(data < 0)
            return Complex((data))
        }

        fun complexFromZeroValue(): Complex {
            return Complex(0)
        }

    }
}