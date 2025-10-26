using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace StudentManagement.Models;

public partial class Course
{
    [Key]
    [Column("CourseID")]
    public int CourseId { get; set; }

    [StringLength(200)]
    public string CourseName { get; set; } = null!;

    [InverseProperty("Course")]
    public virtual ICollection<Enrollment> Enrollments { get; set; } = new List<Enrollment>();
}
