using System;

namespace Codenation.Challenge
{
    public class State
    {
        public State(string name, string acronym)
        {
            this.Name = name;
            this.Acronym = acronym;
        }

                
        public State(string name, string acronym, double area) : this(name, acronym)
        {
            Area = area;
        }

        public string Name { get; set; }

        public string Acronym { get; set; }

        public double Area { get; set; }
    }
}
