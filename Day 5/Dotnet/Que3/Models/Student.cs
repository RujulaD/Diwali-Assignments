using System.ComponentModel.DataAnnotations;

namespace Que3.Models
{
    public class Student
    {
            public int Id { get; set; } // primary key

            [Required, StringLength(100)]
            public string Name { get; set; } = null!;

            [DataType(DataType.Date)]
            [Display(Name = "Birth Date")]
            public DateTime BirthDate { get; set; }

            [StringLength(250)]
            public string? Address { get; set; }

            [Display(Name = "School Name"), StringLength(150)]
            public string? SchoolName { get; set; }

            [Range(0, 100)]
            [Display(Name = "Percentage")]
            public decimal Percentage { get; set; } // decimal for precision
        }
    }



