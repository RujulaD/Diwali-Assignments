using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Que2
{
    class Program
    {
        static void Main()
        {
            int[] IntArray = { 12, 5, 24, 10, 9, 8, 4, 87, 23, 7, 11, 43 };

            
            var result = from num in IntArray
                         where num < 20
                         select num;

            Console.WriteLine("Numbers below 20:");
            foreach (int num in result)
            {
                Console.Write(num + " ");
            }
        }
    }

}
