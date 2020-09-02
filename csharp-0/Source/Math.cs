using System;
using System.Collections.Generic;

namespace Codenation.Challenge
{
    public class Math
    {
        public List<int> Fibonacci()

        {

            List<int> listaFibonacci = new List<int> { 0, 1 };


            for (int i = 2; i <= 13; i++)

            {
                listaFibonacci.Add(listaFibonacci[i - 1] + listaFibonacci[i - 2]);
                
            }

            return listaFibonacci;

        }

        public bool IsFibonacci(int numberToTest)
        {
            return Fibonacci().Contains(numberToTest);
        }
    }
}
