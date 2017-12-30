(ns project.rpc
  (:require-macros
    [javelin.core :refer [defc defc=]])
  (:require
   [javelin.core]
   [castra.core :refer [mkremote]]))

(defc state nil)
(defc error nil)
(defc loading [])

(defc= random-number  (get state :random))
(defc= session-number (get state :session))
(defc= text           (get state :default-text))
(defc= element        (get state :new-element))
(defc= amount-of-text-elements (get state :amount-of-elements))

(def get-state
  (mkremote 'project.api/get-state state error loading))

(defn init []
  (get-state)
  (js/setInterval get-state 1000))
