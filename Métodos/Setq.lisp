(defun factorial (n)
  (if (= n 0)
      1
      (* n (factorial (- n 1)))))
 
(defun cuadrado (x)
  (* x x))
 
(defun area_circulo (radio)
  (* 3.141592653 (* radio radio)))
 
(defun imprimir_resultados ()
  (let ((resultado1 (factorial 5))
        (resultado2 (cuadrado 8))
        (resultado3 (area_circulo 4.5)))
    (format t "El factorial de 5 es: ~A~%" resultado1)
    (format t "El cuadrado de 8 es: ~A~%" resultado2)
    (format t "El área de un círculo con radio 4.5 es: ~A~%" resultado3)))