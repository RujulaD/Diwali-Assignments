using Microsoft.EntityFrameworkCore;

namespace Que3.Models
{
    public class StudentDbContext : DbContext
    {
        public StudentDbContext(DbContextOptions<StudentDbContext> options)
           : base(options)
        {
        }

        public DbSet<Student> Students { get; set; } = null!;
    }
}
