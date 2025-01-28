import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { createPost } from '../Api/BlogApi';

const CreatePostPage = () => {
    const [title, setTitle] = useState('');
    const [author, setAuthor] = useState('');
    const [subheading, setSubheading] = useState('');
    const [content, setContent] = useState('');
    const [imgurl, setImgUrl] = useState('');
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        await createPost({ title, author, subheading, content, imgurl });
        navigate('/');
    };

    return (
        <div className="flex justify-center items-center max-h-screen">
            <div className="bg-white shadow-lg rounded-lg p-8 w-full max-w-md">
                <h1 className="text-2xl font-bold text-gray-800 mb-6 text-center">Create a Post</h1>
                <form onSubmit={handleSubmit} className="space-y-4">
                    <div>
                        <label htmlFor="title" className="block text-sm font-medium text-gray-700">Title</label>
                        <input
                            type="text"
                            id="title"
                            className="mt-1 block w-full border border-gray-300 rounded-md shadow-sm p-2 focus:ring-blue-500 focus:border-blue-500"
                            placeholder="Enter the title"
                            value={title}
                            onChange={(e) => setTitle(e.target.value)} required
                        />
                    </div>
                    <div>
                        <label htmlFor="author" className="block text-sm font-medium text-gray-700">Author</label>
                        <input
                            type="text"
                            id="author"
                            className="mt-1 block w-full border border-gray-300 rounded-md shadow-sm p-2 focus:ring-blue-500 focus:border-blue-500"
                            placeholder="Enter the author's name"
                            value={author}
                            onChange={(e) => setAuthor(e.target.value)} required
                        />
                    </div>
                    <div>
                        <label htmlFor="subheading" className="block text-sm font-medium text-gray-700">Subheading</label>
                        <input
                            type="text"
                            id="subheading"
                            className="mt-1 block w-full border border-gray-300 rounded-md shadow-sm p-2 focus:ring-blue-500 focus:border-blue-500"
                            placeholder="Enter a subheading"
                            value={subheading}
                            onChange={(e) => setSubheading(e.target.value)} required
                        />
                    </div>
                    <div>
                        <label htmlFor="content" className="block text-sm font-medium text-gray-700">Content</label>
                        <textarea
                            id="content"
                            className="mt-1 block w-full border border-gray-300 rounded-md shadow-sm p-2 focus:ring-blue-500 focus:border-blue-500"
                            placeholder="Write the content here"
                            value={content}
                            onChange={(e) => setContent(e.target.value)} required
                        ></textarea>
                    </div>
                    <div>
                        <label htmlFor="image" className="block text-sm font-medium text-gray-700">Image URL</label>
                        <input
                            type="text"
                            id="image"
                            className="mt-1 block w-full border border-gray-300 rounded-md shadow-sm p-2 focus:ring-blue-500 focus:border-blue-500"
                            placeholder="Enter the image URL"
                            value={imgurl}
                            onChange={(e) => setImgUrl(e.target.value)} required
                        />
                    </div>
                    <div>
                        <button
                            type="submit"
                            className=" w-full text-black font-bold py-2 px-4 rounded-md shadow-md focus:outline-none focus:ring-2 focus:ring-blue-400"
                        >
                            Create Post
                        </button>
                    </div>
                </form>
            </div>
        </div>
    );
};

export default CreatePostPage;
