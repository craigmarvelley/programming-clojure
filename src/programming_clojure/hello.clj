(defn hello [name] (str "Hello, " name))

(def visitors (ref #{}))

(defn hello2 
"Prints a greeting and knows if you have been here before"
[username]
(dosync
  (let [past-visitor (@visitors username)]
    (if past-visitor
      (str "Welcome back, " username)
      (do
        (alter visitors conj username)
        (hello username)
)))))
