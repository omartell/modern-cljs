(ns modern-cljs.shopping)

(defn calculate [e]
  (.preventDefault e)
  (println "Calculating")
  (let [quantity (.-value (.getElementById js/document "quantity"))
        price (.-value (.getElementById js/document "price"))
        tax (.-value (.getElementById js/document "tax"))
        discount (.-value (.getElementById js/document "discount"))]
    (set! (.-value (.getElementById js/document "total"))
          (-> (* quantity price)
              (* (+ 1 (/ tax 100)))
              (- discount)
              (.toFixed 2)))
    false))

(defn init []p
  (println "Initializing")
  (if (and js/document
           (.-getElementById js/document))
    (let [form (.getElementById js/document "shoppingForm")]
      (when form
        (set! (.-onsubmit form) calculate)))))

;;(set! (.-onload js/window) init)
