;; Método principal, se llamarán y probarán los otros 3 métodos
(defun main ()
    "Función principal para llamar a los otros métodos"
    (let ((n 10)) ; Cambia este valor por el término de Fibonacci que desees calcular
      (format t "El término ~a de la serie de Fibonacci es: ~a~%" n (fibonacci n))))

;; Método para calcular el término n de la serie Fibonacci
(defun fibonacci (n)
    "Calcula el término n de la serie Fibonacci"
    (cond ((= n 0) 0)
          ((= n 1) 1)
          (t (+ (fibonacci (- n 1)) (fibonacci (- n 2))))))

;; Llama al método principal para iniciar el programa
(main)
