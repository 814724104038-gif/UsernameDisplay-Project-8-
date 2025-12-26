package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        String username = request.getParameter("username");
        
        // Get current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        
        String currentDate = now.format(dateFormatter);
        String currentTime = now.format(timeFormatter);
        
        // Generate random color for username
        String[] colors = {"#FF6B6B", "#4ECDC4", "#FFD166", "#06D6A0", "#118AB2", "#EF476F", "#7209B7"};
        String randomColor = colors[(int)(Math.random() * colors.length)];
        
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("    <title>🌟 Welcome Page | StyleHub</title>");
        out.println("    <link href='https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap' rel='stylesheet'>");
        out.println("    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css'>");
        out.println("    <style>");
        out.println("        * { margin: 0; padding: 0; box-sizing: border-box; }");
        out.println("        body { font-family: 'Poppins', sans-serif; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); min-height: 100vh; display: flex; justify-content: center; align-items: center; padding: 20px; }");
        out.println("        .container { width: 100%; max-width: 500px; }");
        out.println("        .glass-card { background: rgba(255, 255, 255, 0.1); backdrop-filter: blur(15px); border-radius: 25px; padding: 40px; box-shadow: 0 20px 40px rgba(0, 0, 0, 0.3); border: 1px solid rgba(255, 255, 255, 0.2); text-align: center; color: white; animation: fadeIn 0.8s ease-out; }");
        out.println("        @keyframes fadeIn { from { opacity: 0; transform: translateY(20px); } to { opacity: 1; transform: translateY(0); } }");
        out.println("        .success-icon { font-size: 80px; margin-bottom: 20px; color: #4ECDC4; text-shadow: 0 0 20px rgba(78, 205, 196, 0.5); }");
        out.println("        h1 { font-size: 36px; margin-bottom: 10px; font-weight: 700; }");
        out.println("        .username { color: " + randomColor + "; font-weight: 700; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3); font-size: 40px; margin: 20px 0; padding: 10px; background: rgba(255, 255, 255, 0.1); border-radius: 15px; }");
        out.println("        .message { font-size: 18px; margin-bottom: 30px; opacity: 0.9; line-height: 1.6; }");
        out.println("        .info-box { background: rgba(255, 255, 255, 0.15); border-radius: 15px; padding: 20px; margin: 25px 0; }");
        out.println("        .info-item { display: flex; justify-content: space-between; margin-bottom: 10px; font-size: 16px; }");
        out.println("        .info-item:last-child { margin-bottom: 0; }");
        out.println("        .info-label { opacity: 0.8; }");
        out.println("        .info-value { font-weight: 600; }");
        out.println("        .btn { display: inline-block; padding: 15px 30px; background: linear-gradient(to right, #00dbde, #fc00ff); border: none; border-radius: 12px; color: white; font-size: 16px; font-weight: 600; cursor: pointer; transition: all 0.3s ease; text-decoration: none; margin-top: 20px; box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3); }");
        out.println("        .btn:hover { transform: translateY(-3px); box-shadow: 0 8px 20px rgba(0, 0, 0, 0.4); }");
        out.println("        .btn i { margin-right: 10px; }");
        out.println("        .stats { display: flex; justify-content: space-around; margin-top: 30px; }");
        out.println("        .stat-item { text-align: center; }");
        out.println("        .stat-number { font-size: 28px; font-weight: 700; color: #FFD166; }");
        out.println("        .stat-label { font-size: 14px; opacity: 0.8; margin-top: 5px; }");
        out.println("        @media (max-width: 480px) { .glass-card { padding: 30px 20px; } h1 { font-size: 28px; } .username { font-size: 32px; } }");
        out.println("    </style>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <div class='container'>");
        out.println("        <div class='glass-card'>");
        out.println("            <div class='success-icon'>");
        out.println("                <i class='fas fa-check-circle'></i>");
        out.println("            </div>");
        out.println("            <h1>ACCESS GRANTED</h1>");
        out.println("            <p class='message'>You have successfully entered the portal</p>");
        out.println("            ");
        out.println("            <div class='username'>" + username + "</div>");
        out.println("            ");
        out.println("            <div class='info-box'>");
        out.println("                <div class='info-item'>");
        out.println("                    <span class='info-label'><i class='far fa-calendar'></i> Date:</span>");
        out.println("                    <span class='info-value'>" + currentDate + "</span>");
        out.println("                </div>");
        out.println("                <div class='info-item'>");
        out.println("                    <span class='info-label'><i class='far fa-clock'></i> Time:</span>");
        out.println("                    <span class='info-value'>" + currentTime + "</span>");
        out.println("                </div>");
        out.println("                <div class='info-item'>");
        out.println("                    <span class='info-label'><i class='fas fa-user-check'></i> Status:</span>");
        out.println("                    <span class='info-value' style='color: #4ECDC4;'>VERIFIED <i class='fas fa-shield-check'></i></span>");
        out.println("                </div>");
        out.println("            </div>");
        out.println("            ");
        out.println("            <div class='stats'>");
        out.println("                <div class='stat-item'>");
        out.println("                    <div class='stat-number'>" + (int)(Math.random() * 1000 + 500) + "</div>");
        out.println("                    <div class='stat-label'>Active Users</div>");
        out.println("                </div>");
        out.println("                <div class='stat-item'>");
        out.println("                    <div class='stat-number'>" + (int)(Math.random() * 50 + 95) + "%</div>");
        out.println("                    <div class='stat-label'>System Load</div>");
        out.println("                </div>");
        out.println("            </div>");
        out.println("            ");
        out.println("            <a href='index.html' class='btn'>");
        out.println("                <i class='fas fa-arrow-left'></i> BACK TO PORTAL");
        out.println("            </a>");
        out.println("        </div>");
        out.println("    </div>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
}