package com.simplilearn.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.model.ClassShedule;
import com.simplilearn.model.Subject;
import com.simplilearn.util.HibernateSessionUtil;

/**
 * Servlet implementation class AddClassWithSubject
 */
@WebServlet("/add-class-with-subject")
public class AddClassWithSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClassWithSubject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		//request.getRequestDispatcher("add-class-with-subject.html").include(request, response);
		request.getRequestDispatcher("index.html").include(request, response);
		request.getRequestDispatcher("add-class-with-subject.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		//request.getRequestDispatcher("add-class-with-subject.html").include(request, response);
		
		//ClassShedule
	  String section = request.getParameter("section");
	  
	  //subject
	  String SubjectName = request.getParameter("SubjectName");
	  
	// build hibernate session factory
			try {
				// 1. load session factory
				SessionFactory factory =  HibernateSessionUtil.buildSessionFactory();

				// 2. create a session
				Session session = factory.openSession();
				
				// 3. create transaction
				 Transaction tx = session.beginTransaction();
				 
				 //4. create product object & product details
				 ClassShedule classes = new ClassShedule(section);
				 Subject sub = new Subject(SubjectName);
				// classes.setSubject(sub);
				 
				 //5. save product
				 session.save(sub);
				 
				 //6. commit transaction.
				 tx.commit();

				if (session != null) {
					out.print("<h3 style='color:green'> Product is created with product details sucessfully ! </h3>");
				}

				// close session
				session.close();
			} catch (Exception e) {
				out.print("<h3 style='color:red'> Hibernate session is failed ! </h3>");
			}
			
		}

		
		
		
	}


