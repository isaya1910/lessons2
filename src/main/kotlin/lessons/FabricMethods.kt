package lessons


class Complex private constructor(val data: Int) {
    companion object {

        // this fabric method need to use only with positive values
        fun complexFromPositiveValue(data: Int): Complex {
            require(data > 0)
            return Complex(data)
        }

        // this fabric method need to use only with negative values
        fun complexFromNegativeValue(data: Int): Complex {
            require(data < 0)
            return Complex((data))
        }

        fun complexFromZeroValue(): Complex {
            return Complex(0)
        }

    }
}