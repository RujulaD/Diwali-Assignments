using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Que3.Models;

namespace Que3.Controllers
{
   
        [Route("api/[controller]")]
        [ApiController]
        public class StudentsApiController : ControllerBase
        {
            private readonly StudentDbContext _context;

            public StudentsApiController(StudentDbContext context)
            {
                _context = context;
            }

            // GET: api/students
            [HttpGet]
            public async Task<ActionResult<IEnumerable<Student>>> GetAll()
            {
                return await _context.Students.ToListAsync();
            }

            // GET: api/students/5
            [HttpGet("{id:int}")]
            public async Task<ActionResult<Student>> GetById(int id)
            {
                var student = await _context.Students.FindAsync(id);
                if (student == null) return NotFound();
                return student;
            }

            // GET: api/students/marks?min=50&max=80
            [HttpGet("marks")]
            public async Task<ActionResult<IEnumerable<Student>>> GetByMarksRange([FromQuery] decimal min, [FromQuery] decimal max)
            {
                if (min > max) return BadRequest("min must be less than or equal to max.");

                var students = await _context.Students
                                             .Where(s => s.Percentage >= min && s.Percentage <= max)
                                             .ToListAsync();
                return students;
            }

            // Optionally: POST (create), PUT (update), DELETE endpoints for API
            [HttpPost]
            public async Task<ActionResult<Student>> Create(Student student)
            {
                _context.Students.Add(student);
                await _context.SaveChangesAsync();
                return CreatedAtAction(nameof(GetById), new { id = student.Id }, student);
            }

            [HttpPut("{id:int}")]
            public async Task<IActionResult> Update(int id, Student student)
            {
                if (id != student.Id) return BadRequest();
                _context.Entry(student).State = EntityState.Modified;
                try
                {
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!await _context.Students.AnyAsync(e => e.Id == id)) return NotFound();
                    throw;
                }
                return NoContent();
            }

            [HttpDelete("{id:int}")]
            public async Task<IActionResult> Delete(int id)
            {
                var student = await _context.Students.FindAsync(id);
                if (student == null) return NotFound();
                _context.Students.Remove(student);
                await _context.SaveChangesAsync();
                return NoContent();
            }
        }
}
