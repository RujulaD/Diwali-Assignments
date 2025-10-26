using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace StudentManagement.Models
{
    public partial class Student
    {
        [Key]
        [Column("StudentID")]
        public int StudentId { get; set; }

        [Required]
        [StringLength(100)]
        public string FirstName { get; set; } = null!;

        [Required]
        [StringLength(100)]
        public string LastName { get; set; } = null!;

        [DataType(DataType.Date)]
        public DateTime DateOfBirth { get; set; }

        [Required]
        [EmailAddress]
        [StringLength(200)]
        public string Email { get; set; } = null!;

        [Phone]
        [StringLength(15)]
        public string PhoneNumber { get; set; } = null!;

        // ✅ Fix: Add navigation property for Enrollments
        [InverseProperty("Student")]
        public virtual ICollection<Enrollment> Enrollments { get; set; } = new List<Enrollment>();
    }
}
