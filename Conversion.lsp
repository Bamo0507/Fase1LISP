;; Método para convertir grados Fahrenheit a Celsius
(defun fahrenheit-a-celsius (fahrenheit)
  (/ (* (- fahrenheit 32) 5) 9))

;; Método principal
(defun main ()
  (let ((fahrenheit 68)) ; Asignando un valor predeterminado de 68 Fahrenheit
    (let ((celsius (fahrenheit-a-celsius fahrenheit)))
      (format t "La temperatura en grados Celsius es ~a~%" celsius))))

;; Llamada al método principal
(main)

