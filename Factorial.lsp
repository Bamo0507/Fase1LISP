(defun factorial (n)
  ;; Función para calcular el factorial de un número
  (if (<= n 1)
      1
      (* n (factorial (- n 1)))))

(defun main ()
  ;; Método principal
  (let ((num 5)) ; Asignando un valor predeterminado de 5
    (format t "El factorial de ~a es ~a~%" num (factorial num)))) ; Imprime el resultado del factorial de num

(main) ; Llamada al método principal
