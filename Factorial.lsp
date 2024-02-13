(defun factorial (n)
  (if (<= n 1)
      1
      (* n (factorial (- n 1)))))

(defun main ()
  (format t "Ingrese un número para calcular su factorial: ")
  (let ((num (read)))
    (format t "El factorial es" num (factorial num))))

(main)