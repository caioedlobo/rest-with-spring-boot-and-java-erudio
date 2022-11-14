package br.com.erudio.restwithspringbootandjavaerudio.math;

import br.com.erudio.restwithspringbootandjavaerudio.converters.NumberConverter;
import br.com.erudio.restwithspringbootandjavaerudio.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class SimpleMath {

    public Double sum(Double numberOne,Double numberTwo)  {

        return numberOne + numberTwo;
    }

    public Double multi( Double numberOne, Double numberTwo){

        return numberOne * numberTwo;
    }

    public Double subtract(Double numberOne, Double numberTwo){

        return  numberOne - numberTwo;
    }

}
