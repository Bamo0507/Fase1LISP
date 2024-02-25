(defun fibonacci (n)
    "Calcula el término n de la serie Fibonacci"
    (cond ((= n 0) 0)
          ((= n 1) 1)
          (t (+ (fibonacci (- n 1)) (fibonacci (- n 2))))))
