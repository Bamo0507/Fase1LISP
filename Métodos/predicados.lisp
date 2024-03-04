(defun mi-atom-p (x)
  (not (consp x)))

(defun mi-list-p (x)
  (and (consp x) (not (mi-atom-p x))))

(defun mi-equal-p (x y)
  (cond
    ((and (mi-atom-p x) (mi-atom-p y)) (eq x y))
    ((and (mi-list-p x) (mi-list-p y)) (mi-lists-equal-p x y))
    (t nil)))

(defun mi-lists-equal-p (list1 list2)
  (cond
    ((and (null list1) (null list2)) t)
    ((and (mi-atom-p (car list1)) (mi-atom-p (car list2)))
     (and (eq (car list1) (car list2))
          (mi-lists-equal-p (cdr list1) (cdr list2))))
    ((and (mi-list-p (car list1)) (mi-list-p (car list2)))
     (and (mi-equal-p (car list1) (car list2))
          (mi-lists-equal-p (cdr list1) (cdr list2))))
    (t nil)))

(defun mi-less-than-p (x y)
  (cond
    ((and (mi-atom-p x) (mi-atom-p y)) (< x y))
    (t nil)))

(defun mi-greater-than-p (x y)
  (cond
    ((and (mi-atom-p x) (mi-atom-p y)) (> x y))
    (t nil)))

