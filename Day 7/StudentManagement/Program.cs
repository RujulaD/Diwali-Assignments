using Microsoft.EntityFrameworkCore;
using StudentManagement.Models; // namespace for generated context

var builder = WebApplication.CreateBuilder(args);

// Add services
builder.Services.AddControllersWithViews();

builder.Services.AddDbContext<StudentDbContext>(options =>
    options.UseSqlServer(builder.Configuration.GetConnectionString("StudentDb")));

var app = builder.Build();

app.UseStaticFiles();
app.UseRouting();

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}");

app.Run();
