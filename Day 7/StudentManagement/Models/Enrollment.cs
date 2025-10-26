using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace StudentManagement.Models
{
    public partial class Enrollment
    {
        [Key]
        [Column("EnrollmentID")]
        public int EnrollmentId { get; set; }

        [ForeignKey("Student")]
        public int StudentId { get; set; }

        [ForeignKey("Course")]
        public int CourseId { get; set; }

        // ✅ Add this missing property
        [Column(TypeName = "datetime")]
        public DateTime EnrolledOn { get; set; } = DateTime.Now;

        [InverseProperty("Enrollments")]
        public virtual Student Student { get; set; } = null!;

        [InverseProperty("Enrollments")]
        public virtual Course Course { get; set; } = null!;
    }
}
