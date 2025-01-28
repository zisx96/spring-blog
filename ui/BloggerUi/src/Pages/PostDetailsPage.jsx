import React, { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { deletePost, getPostById } from '../Api/BlogApi';

const PostDetailsPage = () => {
    const { id } = useParams();
    const [post, setPost] = useState(null);
    const [showOptions, setShowOptions] = useState(false); 
    const navigate = useNavigate();

    useEffect(() => {
        const fetchPost = async () => {
            const { data } = await getPostById(id);
            setPost(data);
        };
        fetchPost();
    }, [id]);

    if (!post) return <div className="text-center text-lg">Loading...</div>;

    
    const handleEdit = () => {
        navigate(`/edit/${id}`);
    };

   
    const handleDelete = async () => {
        
        const isConfirmed = window.confirm("Are you sure you want to delete this post?");
    
        if (isConfirmed) {
            try {
                await deletePost(id);  
                navigate('/');  
            } catch (error) {
                console.error('Error deleting post:', error);
                alert('There was an error deleting the post. Please try again.');
            }
        }
    };

    return (
        <div className="w-full bg-gray-50 py-6 px-4">
            {/* Post Image */}
            <div className="relative mb-6">
                <img
                    className="w-full h-64 object-cover rounded-lg"
                    src={post?.image_url}
                    alt="Post"
                />
                {/* Options Button (three dots) */}
                <button
                    onClick={() => setShowOptions(!showOptions)}
                    className="absolute top-4 right-4 bg-white p-2 rounded-full shadow-md"
                >
                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 24 24"
                        stroke="currentColor"
                        className="h-6 w-6 text-gray-800"
                    >
                        <path
                            strokeLinecap="round"
                            strokeLinejoin="round"
                            strokeWidth="2"
                            d="M6 12h12M6 6h12M6 18h12"
                        />
                    </svg>
                </button>

                {/* Options Menu */}
                {showOptions && (
                    <div className="absolute top-12 right-4 bg-white shadow-md rounded-md p-2">
                        <button
                            onClick={handleEdit}
                            className="block text-blue-600 w-full py-1 px-4 text-sm hover:bg-gray-100 rounded"
                        >
                            Edit
                        </button>
                        <button
                            onClick={handleDelete}
                            className="block text-red-600 w-full py-1 px-4 text-sm hover:bg-gray-100 rounded"
                        >
                            Delete
                        </button>
                    </div>
                )}
            </div>

            {/* Content Wrapper */}
            <div className="max-w-6xl mx-auto bg-white p-6 rounded-lg">
                {/* Author and Date Info */}
                <div className="text-gray-600 mb-4 flex justify-between items-center">
                    <p className="text-sm font-semibold">{post?.author}</p>
                    <p className="text-sm text-gray-500">{post?.published_date} | 1 min read</p>
                </div>

                {/* Post Title */}
                <h2 className="text-3xl font-bold text-gray-900 mb-4">{post?.title}</h2>

                {/* Subheading */}
                <h3 className="text-xl text-gray-700 mb-6">{post?.subheading}</h3>

                {/* Content */}
                <p className="text-lg text-gray-800 leading-relaxed mb-6">{post?.content}</p>

                {/* Back to Home Button */}
                <div className="mt-6">
                    <button
                        className="px-6 py-2 bg-black text-BLACK rounded-md hover:bg-gray-800"
                        onClick={() => navigate('/')}
                    >
                        Back to Posts
                    </button>
                </div>
            </div>
        </div>
    );
};

export default PostDetailsPage;
