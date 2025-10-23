using Microsoft.AspNetCore.Mvc;
using Que3.Models;

namespace Que3.Controllers
{
        public class StudentsController : Controller
        {
            private readonly StudentDbContext _context;

            public StudentsController(StudentDbContext context)
            {
                _context = context;
            }

            // GET: Students
            public async Task<IActionResult> Index()
            {
                var students = await _context.Students.ToListAsync();
                return View(students);
            }

            // GET: Students/Details/5
            public async Task<IActionResult> Details(int? id)
            {
                if (id == null) return NotFound();

                var student = await _context.Students.FirstOrDefaultAsync(s => s.Id == id);
                if (student == null) return NotFound();

                return View(student);
            }

            // GET: Students/Create
            public IActionResult Create() => View();

            // POST: Students/Create
            [HttpPost]
            [ValidateAntiForgeryToken]
            public async Task<IActionResult> Create([Bind("Name,BirthDate,Address,SchoolName,Percentage")] Student student)
            {
                if (ModelState.IsValid)
                {
                    _context.Add(student);
                    await _context.SaveChangesAsync();
                    return RedirectToAction(nameof(Index));
                }
                return View(student);
            }

            // GET: Students/Edit/5
            public async Task<IActionResult> Edit(int? id)
            {
                if (id == null) return NotFound();

                var student = await _context.Students.FindAsync(id);
                if (student == null) return NotFound();

                return View(student);
            }

            // POST: Students/Edit/5
            [HttpPost]
            [ValidateAntiForgeryToken]
            public async Task<IActionResult> Edit(int id, [Bind("Id,Name,BirthDate,Address,SchoolName,Percentage")] Student student)
            {
                if (id != student.Id) return NotFound();

                if (ModelState.IsValid)
                {
                    try
                    {
                        _context.Update(student);
                        await _context.SaveChangesAsync();
                    }
                    catch (DbUpdateConcurrencyException)
                    {
                        if (!await StudentExists(student.Id)) return NotFound();
                        else throw;
                    }
                    return RedirectToAction(nameof(Index));
                }
                return View(student);
            }

            // GET: Students/Delete/5
            public async Task<IActionResult> Delete(int? id)
            {
                if (id == null) return NotFound();

                var student = await _context.Students.FirstOrDefaultAsync(m => m.Id == id);
                if (student == null) return NotFound();

                return View(student);
            }

            // POST: Students/Delete/5
            [HttpPost, ActionName("Delete")]
            [ValidateAntiForgeryToken]
            public async Task<IActionResult> DeleteConfirmed(int id)
            {
                var student = await _context.Students.FindAsync(id);
                if (student != null)
                {
                    _context.Students.Remove(student);
                    await _context.SaveChangesAsync();
                }
                return RedirectToAction(nameof(Index));
            }

            private async Task<bool> StudentExists(int id)
            {
                return await _context.Students.AnyAsync(e => e.Id == id);
            }
        }
    }


