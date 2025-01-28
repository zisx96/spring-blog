import React from 'react'
import './App.css'
import Home from '../src/Pages/Home'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import PostDetailsPage from './Pages/PostDetailsPage';
import CreatePostPage from './Pages/CreatePostPage';
import PostEditPage from'./Pages/PostEditPage';

function App() {

  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/:id" element={<PostDetailsPage />} />
        <Route path="/create" element={<CreatePostPage />} />
        <Route path="/edit/:id" element={<PostEditPage/>} />
      </Routes>
    </Router>
  )
}

export default App
