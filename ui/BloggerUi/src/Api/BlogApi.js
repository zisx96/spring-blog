import axios from 'axios';

const API_URL = 'http://localhost:8484/Blogger/api/blog';

export const getAllPost = async () => axios.get(`${API_URL}`);

export const getPostById = async (id) => axios.get(`${API_URL}/${id}`);

export const createPost = async (postData) =>
  axios.post(`${API_URL}`, postData);

export const deletePost = async (id) => axios.delete(`${API_URL}/${id}`);

export const editPost = async (id, post) => axios.put(`${API_URL}/${id}`,post);